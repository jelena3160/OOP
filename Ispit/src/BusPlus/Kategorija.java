package BusPlus;

public enum Kategorija {
    A1(0){
        @Override
        public String toString() {
            return "zaposleni";
        }
    },
    P2(1){
        @Override
        public String toString() {
            return "srednjoskolci";
        }
    },
    P3(2){
        @Override
        public String toString() {
            return "studenti";
        }
    },
    P13(3){
        @Override
        public String toString() {
            return "penzioneri";
        }
    };

    private final int  op;
    private Kategorija(int op){
        this.op = op;
    }

    public static Kategorija izBroja(int op){
        switch(op){
            case 0: return A1;
            case 1: return P2;
            case 2: return P3;
            default: return P13;
        }
    }



}
