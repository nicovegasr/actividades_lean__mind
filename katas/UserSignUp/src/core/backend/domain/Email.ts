export class Email {
  private constructor(public email: string) {  }

  public static createEmail(email: string): Email {
    const incorrectFormat = !(email.match(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/))
    if (!email) { throw new Error("Email is empty.") }
    if (incorrectFormat) { throw new Error("Email doesnt have the correct format.")}
    return new Email(email)
  }
}