package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;

public class mainForSpring {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException{
		/*
		 * �꽕�젙 �뙆�씪 �뿬�윭 媛� �궗�슜 �떆�뿉�뒗 AnnotationConfigApplicationContext �븿�닔�뿉 , 濡� 援щ텇�빐 �꽔�뼱二쇰㈃�맖.
		 * */
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("紐낅졊�뼱瑜� �엯�젰�븯�꽭�슂");
			String command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("醫낅즺�빀�땲�떎");
				break;
			}
			
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}
			
			if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			
			if(command.startsWith("list")){
				processListCommand();
				continue;
			}
			
			if(command.startsWith("info")){
				processInfoCommand(command.split(" "));
				continue;
			}
			
			if(command.equals("version")){
				processVersionCommand();
				continue;
			}
		}
		printHelp();
	}
	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("�븫�샇�� �솗�씤�씠 �씪移섑븯吏� �븡�뒿�땲�떎.\n");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("�벑濡앺뻽�뒿�땲�떎.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("�씠誘� 議댁옱�븯�뒗 �씠硫붿씪�엯�땲�떎.\n");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc =
				ctx.getBean(ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("�븫�샇瑜� 蹂�寃쏀뻽�뒿�땲�떎.");
		}catch(MemberNotFoundException e) {
			System.out.println("議댁옱�븯吏� �븡�뒗 �씠硫붿씪�엯�땲�떎.\n");
		}catch(WrongIdPasswordException e) {
			System.out.println("�씠硫붿씪怨� �븫�샇媛� �씪移섑븯吏� �븡�뒿�땲�떎.\n");
		}
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("�옒紐삳맂 紐낅졊�엯�땲�떎. �븘�옒 紐낅졊�뼱 �궗�슜踰뺤쓣 �솗�씤�븯�꽭�슂.");
		System.out.println("紐낅졊�뼱 �궗�슜踰�");
		System.out.println("new �씠硫붿씪 �씠由� �븫�샇 �븫�샇�솗�씤");
		System.out.println("change �씠硫붿씪 �쁽�옱鍮꾨쾲 蹂�寃쎈퉬踰�");
		System.out.println();
	}
	
	private static void processListCommand(){
		MemberListPrinter listPrinter = 
				ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg){
		if(arg.length != 2){
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter
		 = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVersionCommand(){
		VersionPrinter versionPrinter =
				ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
}
