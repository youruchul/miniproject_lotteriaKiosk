package com.lotteria.kiosk.exception;

public class ErrorCode {
	private String[] msg = new String[]{"",
			"�̹� ��ϵ� ���̵��Դϴ�!",
			"ȸ�������� �Ϸ�Ǿ����ϴ�!",
			"���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�!",
			"�޴� ��Ͽ� �����߽��ϴ�!",
			"���ο� �޴��� ��ϵǾ����ϴ�!",
			"������ �����Ͽ����ϴ�!", 
			"������ �Ϸ�Ǿ����ϴ�!",
			"������ �����Ͽ����ϴ�!",
			"������ �Ϸ�Ǿ����ϴ�!"};

	public String get(String code) {
		try {
			return msg[Integer.parseInt(code)];			
		} catch (Exception e) {
			return "";
		}
	}
}