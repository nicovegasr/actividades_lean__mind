export class Email {
  private constructor(public email: string) {  }

  public static createEmail(email: string): Email {
    if (!email) { throw new Error("Email is empty.") }
    return new Email(email)
  }
}