package pl.javastart.textstats;

class TextStatsDto {
    private String text;
    private Integer length;
    private Integer words;
    private Boolean isPalindrome;
    private String mostPopularWord;
    private Integer mostPopularWordCount;

    public TextStatsDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Boolean getPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }

    public String getMostPopularWord() {
        return mostPopularWord;
    }

    public void setMostPopularWord(String mostPopularWord) {
        this.mostPopularWord = mostPopularWord;
    }

    public Integer getMostPopularWordCount() {
        return mostPopularWordCount;
    }

    public void setMostPopularWordCount(Integer mostPopularWordCount) {
        this.mostPopularWordCount = mostPopularWordCount;
    }
}
