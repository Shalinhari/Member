package com.project.Member.exception;

public class MemberNotFoundException extends RuntimeException {
	public MemberNotFoundException(String reason) {
		super(reason);
	}

}
