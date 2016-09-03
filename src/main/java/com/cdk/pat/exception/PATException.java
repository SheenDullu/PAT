package com.cdk.pat.exception;

/**
 * Created by dullus on 9/2/2016.
 */
public class PATException extends Exception{
        String errorMessage;

        public PATException(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return "PATException{" +
                    "errorMessage='" + errorMessage + '\'' +
                    '}';
        }
}

