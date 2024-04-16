class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));

    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<Data> data = map.get(key);
        return findClosestValue(data, timestamp);

    }

    private String findClosestValue(List<Data> data, int timeStamp) {
        int l = 0;
        int r = data.size() - 1;

        while (l < r) {
            //inorder to avoid getting stuck in an infinite loop
            int mid = (l + r + 1) / 2;

            if (data.get(mid).timeStamp <= timeStamp) {
                l = mid;
            }

            else {
                r = mid-1;
            }

        }
        Data closestData = data.get(l);
        return closestData.timeStamp > timeStamp ? "" : closestData.value;
    }

    class Data {
        String value;
        int timeStamp;

        public Data(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */