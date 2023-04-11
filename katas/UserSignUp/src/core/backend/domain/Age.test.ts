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

})