export class UserRequestValidate {
  private constructor(private name: string, private email: string, private password: string, private age: number) {}

  public static create(name: string, email: string, password: string, age: number): UserRequestValidate {
    UserRequestValidate.validateName(name);
    UserRequestValidate.validateEmail(email );
    UserRequestValidate.validatePassword(password);
    UserRequestValidate.validateAge(age);
    return new UserRequestValidate(name, email, password, age);
  }
  public static validateName(name: string) {
    if (name === undefined) {
      throw new Error("User name is undefined.");
    }
    if (name.length === 0) {
      throw new Error("User name is empty.");
    }
  }
  public static validateEmail(email: string) {
    const emailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$");
    if (email === undefined) {
      throw new Error("User email is undefined.");
    }
    if (email.length === 0) {
      throw new Error("User email is empty.");
    }
    if (!emailRegex.test(email)) {
      throw new Error("User email is invalid.");
    }
  }
  public static validatePassword(password: string) {
    if (password === undefined) {
      throw new Error("User password is undefined.");
    }
    if (password.length === 0) {
      throw new Error("User password is empty.");
    }
    if (password.length < 6) {
      throw new Error("User password is less than 6 characters.");
    }
  }
  public static validateAge(age: number) {
    if (age === undefined) {
      throw new Error("User age is undefined.");
    }
    if (age < 18) {
      throw new Error("User age is less than 18.");
    }
    if (Number.isInteger(age) === false) {
      throw new Error("User age is not a number.");
    }
  }
  public getName(): string {
    return this.name;
  }
  public getEmail(): string {
    return this.email;
  }
  public getPassword(): string {
    return this.password;
  }
  public getAge(): number {
    return this.age;
  }
}