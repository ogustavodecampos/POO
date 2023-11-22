class Equipe {
    private String codinome;
    private int qtd;
    private double latitude;
    private double longitude;

    public Equipe(String codinome, int qtd, double latitude, double longitude) {
        this.codinome = codinome;
        this.qtd = qtd;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCodinome() {
        return codinome;
    }

    public int getQtd() {
        return qtd;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}


//(solicita e cadastra os dados de uma equipe [se o
//      codinome já existir, mostra uma mensagem de erro]. As equipes são mantidas em
//    ordem crescente de codinome).