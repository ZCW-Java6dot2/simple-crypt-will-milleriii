public class CaesarCipher extends ROT13 {
    private int caesarShift;


    public String crypt(String text, int caesarShift) throws UnsupportedOperationException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char c = (char) (((int) text.charAt(i) + caesarShift - 65) % 26 + 65);
                result.append(c);
            } else {
                char c = (char) (((int) text.charAt(i) + caesarShift - 97) % 26 + 97);
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String encrypt(String text){
        return super.encrypt(text);
    }

    @Override
    public String decrypt(String text){
        return super.decrypt(text);
    }
}
