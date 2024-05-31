class Persik extends Tanaman implements Perawatan {
    public Persik() {
        super(180, 250, 15);
    }

    @Override
    public void berkembang() {
        setProsesBerbuah(getProsesBerbuah() + getPerkembangan());
        setLamaHidup(getLamaHidup() + 1);
        if (getProsesBerbuah() >= getBerbuah()) {
            setBuah(getBuah() + 1);
            setProsesBerbuah(getProsesBerbuah() - getBerbuah());
        }
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 2.5);
    }
}