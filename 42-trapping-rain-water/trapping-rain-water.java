class Solution {
    public int trap(int[] height) {
        int l = 0;
        int n = height.length - 1;
        int r = n;
        int rw = 0;
        int lw = 0;
        int result = 0;

        while (l <= r) {
            if (lw >= rw) {
                if (rw > height[r]) {
                    result = result + (rw - height[r]);
                } else {
                    rw = height[r];
                }
                r--;
            }

            else {

                if (lw > height[l]) {
                    result = result + (lw - height[l]);
                } else {
                    lw = height[l];
                }
                l++;

            }
        }
        return result;

    }
}