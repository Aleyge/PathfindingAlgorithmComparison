public class Edge {
    public final int startX; // Başlangıç x koordinatı
    public final int startY; // Başlangıç y koordinatı
    public final int endX;   // Bitiş x koordinatı
    public final int endY;   // Bitiş y koordinatı
    public final double distance; // İki nokta arasındaki mesafe

    // Constructor: Kenarın başlangıç ve bitiş koordinatlarını alır
    public Edge(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.distance = calculateDistance(); // Mesafeyi hesapla
    }

    // İki nokta arasındaki Euclidean mesafesini hesaplar
    private double calculateDistance() {
        return Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }

    // Kenarın diğer uç noktasını alır
    public int[] getOtherCoordinates(int x, int y) {
        if (x == startX && y == startY) {
            return new int[]{endX, endY};
        } else if (x == endX && y == endY) {
            return new int[]{startX, startY};
        }
        return null;
    }
}
