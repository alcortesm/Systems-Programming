class TreeTest {

    private static Tree thor() {
        Tree fili   = new Tree("Fíli", new Forest());
        Tree kili   = new Tree("Kíli", new Forest());

        Forest disChildren = new Forest();
        disChildren.enqueue(fili);
        disChildren.enqueue(kili);
        Tree dis    = new Tree("Dís", disChildren);

        Tree thorin = new Tree("Thorin II", new Forest());
        Tree frerin = new Tree("Frerin", new Forest());

        Forest thrainChildren = new Forest();
        thrainChildren.enqueue(thorin);
        thrainChildren.enqueue(frerin);
        thrainChildren.enqueue(dis);
        Tree thrain = new Tree("Thráin II", thrainChildren);

        Forest thorChildren = new Forest();
        thorChildren.enqueue(thrain);
        Tree thor   = new Tree("Thór", thorChildren);

        return thor;
    }

    public static void main(String args[]) {
        Tree thor = thor();
        System.out.print(thor);
    }
}
