package automata

import kotlin.test.Test
import kotlin.test.assertEquals

class NFATests {
    @Test
    fun testIsMatch() {
        val state0 = State("0");
        val state1 = State("1");
        val state2 = State("2");

        val rule0 = Rule(state0, 'A', state1);
        val rule0_0 = Rule(state0, 'A', state0);
        val rule1 = Rule(state1, 'B', state2);

        val nfa0 = NFA(setOf(state0), setOf(state0, state1, state2), setOf(rule0, rule0_0, rule1));
        var ret = nfa0.isMatch("AB");
        assertEquals(true, ret);

        val nfa1 = NFA(setOf(state0), setOf(state0, state1), setOf(rule0, rule0_0, rule1));
        ret = nfa1.isMatch("AB");
        assertEquals(false, ret);

        val nfa2 = NFA(setOf(state0), setOf(state0), setOf(rule0, rule0_0, rule1));
        ret = nfa2.isMatch("A");
        assertEquals(true, ret);

        val nfa3 = NFA(setOf(state0), setOf(state1), setOf(rule0, rule0_0, rule1));
        ret = nfa3.isMatch("A");
        assertEquals(true, ret);

        val nfa4 = NFA(setOf(state0), setOf(state1), setOf(rule0, rule0_0, rule1));
        ret = nfa4.isMatch("AA");
        assertEquals(true, ret);

        val nfa5 = NFA(setOf(state0), setOf(state2), setOf(rule0, rule0_0, rule1));
        ret = nfa5.isMatch("AAB");
        assertEquals(true, ret);
    }
}