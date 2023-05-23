import {UserRequestValidate} from "./UserRequestValidate";

describe("User test to validate requests", () => {
  it("should create the user.", () => {
    const userRequestValidate =  UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 18);
    
    expect(userRequestValidate).toBeInstanceOf(UserRequestValidate);
  })
  describe("Name Validations", () => {
    it("should not create the user because name is empty.", () => {    
      expect(() => UserRequestValidate.create("", "prueba@gmail.com", "prueba", 18)).toThrow("User name is empty.");
    })
  })
  describe("Email Validations", () => {
    it("should not create the email because email is empty.", () => {    
      expect(() => UserRequestValidate.create("prueba", "", "prueba", 18)).toThrow("User email is empty.");
    })
    it("should not create the email because email is invalid.", () => {    
      expect(() => UserRequestValidate.create("prueba", "prueba.com", "prueba", 18)).toThrow("User email is invalid.");
    })
  })
  describe("Password Validations", () => {
    it("should not create the user because password is empty.", () => {
      expect(() => UserRequestValidate.create("prueba", "prueba@gmail.com", "", 18)).toThrow("User password is empty.");
    })
    it("should not create the user because password is less than 6 characters.", () => {
      expect(() => UserRequestValidate.create("prueba", "prueba@gmail.com", "prueb", 18)).toThrow("User password is less than 6 characters.");
    })
  })
  describe("Age Validations", () => {
    it("should not create the user because age is less than 18.", () => {
      expect(() => UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 17)).toThrow("User age is less than 18.");
    })
    it("should not create the user because age is not a number.", () => {
      expect(() => UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 20.5)).toThrow("User age is not a number.");
    })
  })
})