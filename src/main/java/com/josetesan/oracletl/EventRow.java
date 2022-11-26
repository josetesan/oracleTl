package com.josetesan.oracletl;

import java.util.Date;

public record EventRow(Long id, Date createDate, String payload, String tipo) {}
