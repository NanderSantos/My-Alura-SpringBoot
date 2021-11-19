package br.com.alura.store.http;

import java.util.Map;

public interface HttpAdapter {

    void post(String url, Map<String, Object> data);
}
