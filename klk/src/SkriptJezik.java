public enum SkriptJezik {
    Python {
        @Override
        public String toString() {
            return "py";
        }
    },
    Perl {
        @Override
        public String toString() {
            return "pl";
        }
    },
    PHP {
        @Override
        public String toString() {
            return "php";
        }
    },
    JavaScript {
        @Override
        public String toString() {
            return "js";
        }
    },
    Ruby {
        @Override
        public String toString() {
            return "rb";
        }
    },
    Lua {
        @Override
        public String toString() {
            return "lua";
        }
    };

}
