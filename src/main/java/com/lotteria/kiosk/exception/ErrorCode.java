package com.lotteria.kiosk.exception;

public class ErrorCode {
	private String[] msg = new String[]{"",
			"이미 등록된 아이디입니다!",
			"회원가입이 완료되었습니다!",
			"아이디 혹은 비밀번호가 잘못되었습니다!",
			"메뉴 등록에 실패했습니다!",
			"새로운 메뉴가 등록되었습니다!",
			"삭제에 실패하였습니다!", 
			"삭제가 완료되었습니다!",
			"수정에 실패하였습니다!",
			"수정이 완료되었습니다!"};

	public String get(String code) {
		try {
			return msg[Integer.parseInt(code)];			
		} catch (Exception e) {
			return "";
		}
	}
}