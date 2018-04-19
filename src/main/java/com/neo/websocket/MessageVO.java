package com.neo.websocket;

import lombok.Data;

/**
 * websocket相关的bean
 */

@Data
public class MessageVO {


    private Integer userNum;


    private Integer type;


    private String message;

}