public class CompteBancari {
    private String titular;
    private String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no pot ser nul o buit.");
        }
        if (iban == null || iban.trim().isEmpty()) {
            throw new IllegalArgumentException("L'IBAN no pot ser nul o buit.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no pot ser negatiu.");
        }

        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat a ingressar ha de ser positiva.");
        }
        saldo += quantitat;
    }

    public void retirar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat a retirar ha de ser positiva.");
        }
        if (quantitat > saldo) {
            throw new IllegalArgumentException("No hi ha prou saldo per retirar aquesta quantitat.");
        }
        saldo -= quantitat;
    }

    public void mostrarDades() {
        System.out.println("Titular: " + titular);
        System.out.println("IBAN: " + iban);
        System.out.println("Saldo: " + saldo);
        imprimirEstatSaldo();
    }

    private void imprimirEstatSaldo() {
        if (saldo < 1000) {
            System.out.println("Saldo baix");
        } else if (saldo >= 1000 && saldo < 5000) {
            System.out.println("Saldo normal");
        } else {
            System.out.println("Saldo alt");
        }
    }

    public String getTitular() {
        return titular;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
}