export class Email {
  private constructor(public email: string) {  }

  public static createEmail(email: string): Email {
    throw new Error("Not implemented")
  }
}