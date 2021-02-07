package com.ims.sampleproject.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class App extends Throwable {

    private final String message;

}
