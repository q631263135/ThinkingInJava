package 枚举类型;

/**
 * Created by ycz on 2018/2/11 0011.
 */
public enum TimeUnitImi {

    MILLISECONDS {
        @Override
        public long toMillis(long duration) {
            return 1L;
        }
    }, SECONDS;

    public long toMillis(long duration) {
        throw new AbstractMethodError();
    }
}
