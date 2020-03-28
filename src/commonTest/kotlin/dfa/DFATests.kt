package dfa

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DFATests {
    @Test
    fun testIsMatch() {
        val state0 = State ("0");
        val state1 = State("1");
        val state2 = State("2");

        val rule0 = Rule(state0, 'A', state1);
        val rule1 = Rule(state1, 'B', state2);

        val dfa = DFA(state0, setOf(state0, state1, state2), setOf(rule0, rule1));

        var ret = dfa.isMatch("AB");
        assertEquals(true, ret);

        ret = dfa.isMatch("A");
        assertEquals(false, ret);

        ret = dfa.isMatch("CDE");
        assertEquals(false, ret);
    }
}