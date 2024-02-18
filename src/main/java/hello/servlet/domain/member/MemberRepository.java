package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
*/
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    // store에 있는 값을 모두 꺼내 새로운 ArrayList에 담아 넘겨줌
    // 새로 저장을 하거나 꺼내도 store를 보호하기 위해 이런 방식 사용
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
