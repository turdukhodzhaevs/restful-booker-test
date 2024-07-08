package org.booker;

public enum StatusCode {
    Status200OK(200),
    Status400BadRequest(400),
    Status500ServerError(500);
    public final int code;

    StatusCode(int code) {
        this.code = code;
    }
}
