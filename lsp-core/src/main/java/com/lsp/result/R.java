package com.lsp.result;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by songbo on 2018/8/1.
 */
public class R extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = -6895064778206181274L;

    public static R ok(Object msg) {
        R r = new R();
        r.put("code", 200);
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object msg,Object obj) {
        R r = new R();
        r.put("msg", msg);
        r.put("code", 200);
        r.put("obj", obj);
        return r;
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
