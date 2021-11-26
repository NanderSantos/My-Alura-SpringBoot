package br.com.alura.tdd.service;

import java.math.BigDecimal;

public enum Performance {

    UNSATISFACTORY {
        @Override
        public BigDecimal readjustPercentual() {
            return new BigDecimal("0.03");
        }
    },
    OK {
        @Override
        public BigDecimal readjustPercentual() {
            return new BigDecimal("0.15");
        }
    },
    EXCELLENT {
        @Override
        public BigDecimal readjustPercentual() {
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal readjustPercentual();
}
