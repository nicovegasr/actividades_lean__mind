import {Age} from "./Age";
/** Approach: Inside-out
 * 1.- Age is created
 * 2.- Age under 13 cant be created -> throw Error
 */
describe('Age test.', () => {

  test('Age is created with factory method.', () => {
    const myAge: Age = Age.createAge(18);
    expect(myAge).toBeInstanceOf(Age)
  });

  test('Age under 13 thrown an error', () => {
    expect(() => Age.createAge(12)).toThrow("You have to be 13 years old or older to create an Age.")
  });
})