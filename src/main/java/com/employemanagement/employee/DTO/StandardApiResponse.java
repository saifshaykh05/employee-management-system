package com.employemanagement.employee.DTO;

public class StandardApiResponse {
    private String message;
    private int Status;
    private Object data;

    public StandardApiResponse(String message, int status, Object data) {
        this.message = message;
        Status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
