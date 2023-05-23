import { User } from "../../domain/models/User"
import { UserRequestValidate } from "../validate/UserRequestValidate"
import { UserDTO } from "./UserDTO"

describe("User DTO", () => {
  it ("should create the domain user from DTO.", () => {
    const userRequestValidate =  UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 18);
    const user = UserDTO.createDomainUser(userRequestValidate);
    expect(user).toBeInstanceOf(User);
  })
})