package com.cstructor.androidinterfaces;

import com.google.gson.annotations.SerializedName;

public class RandomResponse {
    @SerializedName("jsonrpc")
    private String jsonRpc;

    private String id;

    private Result result;

    public String getJsonRpc() {
        return jsonRpc;
    }

    public void setJsonRpc(String jsonRpc) {
        this.jsonRpc = jsonRpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private int bitsUsed;
        private int bitsLeft;
        private Random random;

        public int getBitsUsed() {
            return bitsUsed;
        }

        public void setBitsUsed(int bitsUsed) {
            this.bitsUsed = bitsUsed;
        }

        public int getBitsLeft() {
            return bitsLeft;
        }

        public void setBitsLeft(int bitsLeft) {
            this.bitsLeft = bitsLeft;
        }

        public Random getRandom() {
            return random;
        }

        public void setRandom(Random random) {
            this.random = random;
        }


        public class Random{
            private int[] data;

            public int[] getData() {
                return data;
            }

            public void setData(int[] data) {
                this.data = data;
            }
        }
    }


}
