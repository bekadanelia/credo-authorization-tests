package ge.beka.credo.data;

public final class SecurityPayloads {

    public static final String SQL_INJECTION_PAYLOAD = "' OR 1=1 --";
    public static final String XSS_PAYLOAD = "<script>alert(1)</script>";
    public static final String WHITESPACE_USERNAME = "  testuser  ";

    private SecurityPayloads() {
    }
}
