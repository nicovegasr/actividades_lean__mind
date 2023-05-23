import {UserRequestValidate} from "./UserRequestValidate";

describe("User test to validate requests", () => {
  it("should create the user.", () => {
    const userRequestValidate =  UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 18);
    
    expect(userRequestValidate).toBeInstanceOf(UserRequestValidate);
  })
  it("should not create the user because name is empty.", () => {    
    expect(UserRequestValidate.create("", "prueba@gmail.com", "prueba", 18)).toThrow("User name is empty.");
  })
});