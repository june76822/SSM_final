package controller;

import controller.action.*;
import controller.action.LoginAction;

public class ActionFactory {
	private ActionFactory() {} ; 
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join")) action = new JoinAction();
		else if(command.equals("login")) action =new LoginAction();
		else if(command.equals("logout")) action = new LogoutAction();
		else if(command.equals("writeBoard")) action = new BoardWriteAction();
		else if(command.equals("updateBoard")) action = new BoardUpdateAction();
		else if(command.equals("deleteBoard")) action = new BoardDeleteAction();
		else if(command.equals("myPage")) action=new MyPageAction();
		else if(command.equals("addCart")) action = new addCartAction();
		else if(command.equals("addWish")) action = new addWishAction();
		else if(command.equals("search")) action = new SearchAction();
		else if(command.equals("cart"))action=new CartAction();
		else if(command.equals("modifyProfile"))action=new ModifyProfileAction();
		else if(command.equals("order")) action = new OrderAction();
		else if(command.equals("deleteMember"))action = new DeleteMemberAction();
		else if(command.equals("passwordCheck"))action = new PasswordCheckAction();
		else if(command.equals("removeCart"))action = new removeCartAction();
		else if(command.equals("removeWish"))action = new removeWishAction();
//		else if(command.equals("wishToCart"))action = new wishToCartAction();
		else if(command.equals("findPassword"))action = new FindPasswordAction();
		
		return action;
	}
	
	
}
