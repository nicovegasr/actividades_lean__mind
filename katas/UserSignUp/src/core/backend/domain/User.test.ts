import {User} from "./User"

/** Approach: Inside-out
 * 1.- Wrong Email (Empty or not format) will throw an Error
 * 2.- Empty Name will throw an Error
 * 3.- Wrong Age (under 13 or float) will throw an Errorç.
 * 4.- Correct fields will create an user.
*/

describe('User test.', () => {

  describe('Wrong Email test.', () => {
    it('Empty Email will throw an Error.', () => {
      expect(() => User.createUser("Nico", 22, "") ).toThrow("Email is empty.")
    })
    it('Non-format Email will throw an Error.', () => {
      expect(() => User.createUser("Nico", 22, "non-format@") ).toThrow("Email doesnt have the correct format.")
    })
  })

  describe('Wrong Name test.', () => {
    it('Empty Name will throw an Error.', () => {
      expect(() => User.createUser("", 22, "nico@gmail.com") ).toThrow("Name cannot be empty.")
    })
  
  })

  describe('Wrong Age test.', () => {
    it('Age under 13 will throw an Error.', () => {
      expect(() => User.createUser("Nico", 10, "nico@gmail.com") ).toThrow("You have to be 13 years old or older to create an Age.")
    })
    it('Float age will throw an Error.', () => {
      expect(() => User.createUser("Nico", 17.5, "nico@gmail.com") ).toThrow("Age must be an integer.")
    })
  
  })

  describe('Correct fields test.', () => {

  
  })

})