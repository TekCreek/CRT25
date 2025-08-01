class Message {
    private String body;  // required
    private String title; // optional
    private String recipient; // optional

    // Private constructor to force use of the builder
    private Message(MessageBuilder builder) {
        this.body = builder.body;
        this.title = builder.title;
        this.recipient = builder.recipient;
    }

    public void print() {
        System.out.println("Title: " + (title != null ? title : "(no title)"));
        System.out.println("To: " + (recipient != null ? recipient : "(no recipient)"));
        System.out.println("Message: " + body);
    }

    public static class MessageBuilder {
        private String body;    // required
        private String title;   // optional
        private String recipient; // optional

        public MessageBuilder(String body) {
            this.body = body;
        }

        public MessageBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MessageBuilder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}

// Example usage
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Message msg = new Message.MessageBuilder("This is your notification!")
                .setTitle("Alert")
                .setRecipient("Sagar")
                .build();
        msg.print();
    }
}
