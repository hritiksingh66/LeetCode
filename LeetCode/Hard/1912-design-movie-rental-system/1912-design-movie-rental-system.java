class MovieRentingSystem {
    record MovieEntity(int shop, int movie, int price) {}

    Map<Integer, TreeSet<MovieEntity>> available = new HashMap<>();
    TreeSet<MovieEntity> rented = new TreeSet<>(Comparator
        .comparingInt((MovieEntity me) -> me.price)
        .thenComparingInt(me -> me.shop)
        .thenComparingInt(me -> me.movie));
    
    Map<List<Integer>, MovieEntity> movieMap = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            MovieEntity me = new MovieEntity(shop, movie, price);
            movieMap.put(List.of(shop, movie), me);
            available.computeIfAbsent(movie, k -> new TreeSet<>(Comparator
                .comparingInt((MovieEntity x) -> x.price)
                .thenComparingInt(x -> x.shop)))
                .add(me);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (available.containsKey(movie)) {
            int count = 0;
            for (MovieEntity me : available.get(movie)) {
                res.add(me.shop);
                if (++count == 5) break;
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        MovieEntity me = movieMap.get(List.of(shop, movie));
        available.get(movie).remove(me);
        rented.add(me);
    }

    public void drop(int shop, int movie) {
        MovieEntity me = movieMap.get(List.of(shop, movie));
        rented.remove(me);
        available.get(movie).add(me);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (MovieEntity me : rented) {
            res.add(List.of(me.shop, me.movie));
            if (++count == 5) break;
        }
        return res;
    }
}