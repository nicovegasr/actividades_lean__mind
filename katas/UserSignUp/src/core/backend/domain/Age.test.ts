import {Age} from "./Age";
/** Approach: Inside-out
 * 1.- Age is created
 */
describe('Age test.', () => {

  test('Age is created.', () => {
    const myAge: Age = new Age(18);
    expect(myAge.age).toBe(18)
  });

})