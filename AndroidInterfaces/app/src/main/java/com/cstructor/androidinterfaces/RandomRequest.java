package com.cstructor.androidinterfaces;

import com.google.gson.annotations.SerializedName;

public class RandomRequest {
    @SerializedName("jsonrpc")
    private String jsonRpc;
    private String method;
    private String id;
    private Params params;

    public RandomRequest(){
        setParams(new Params());
    }

    public String getJsonRpc() {
        return jsonRpc;
    }

    public void setJsonRpc(String jsonRpc) {
        this.jsonRpc = jsonRpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public class Params {
        private String apiKey;
        private int n;
        private int min;
        private int max;
        private boolean replacement;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public boolean isReplacement() {
            return replacement;
        }

        public void setReplacement(boolean replacement) {
            this.replacement = replacement;
        }
    }
}
