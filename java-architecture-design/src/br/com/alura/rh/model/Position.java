package br.com.alura.rh.model;

public enum Position {

    ASSISTENT {
        @Override
        public Position getNextPosition() {
            return ANALIST;
        }
    },
    ANALIST {
        @Override
        public Position getNextPosition() {
            return SPECIALIST;
        }
    },
    SPECIALIST {
        @Override
        public Position getNextPosition() {
            return MANAGER;
        }
    },
    MANAGER {
        @Override
        public Position getNextPosition() {
            return MANAGER;
        }
    };

    public abstract Position getNextPosition();
}
