public class TobogganPathfinder {

    private boolean[][] terrain;

    public TobogganPathfinder(boolean[][] terrain) {
        this.terrain = terrain;
    }

    public void PrintTerrain() {
        for(boolean[] line : terrain) {
            for(boolean b : line) {
                System.out.print(b ? '#' : '.');
            }

            System.out.println();
        }
    }

    public int CountTreesInPath(int xStep, int yStep) {
        int x = 0;
        int y = 0;
        int trees = 0;

        while(y + yStep < terrain.length) {
            x = (x + xStep) % terrain[0].length;
            y += yStep;

            if(terrain[y][x]) {
                trees++;
            }

            
        }

        return trees;
    }
}