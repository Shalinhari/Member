package com.project.Member.exception;

import org.springframework.stereotype.Component;

@Component
public class NotFound {
private String result;
protected NotFound() {
	
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}


}
