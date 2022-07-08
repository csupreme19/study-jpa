package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaRepositoryTests {
    private static final Logger log = LoggerFactory.getLogger(JpaRepositoryTests.class);

    private static final String TEST_USER_ID = "csupreme19";
    private static final Long TEST_PERSON_ID = 1L;
    private static final Long TEST_POST_ID = 1L;
    private static final String TEST_MODIFIER_ID = "honggilsoon19";
    private static final Long TEST_TAG_ID = 1L;
    private static final Long TEST_ITEM_ID = 1L;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("OneToOne 양방향 매핑 테스트")
    public void oneToOneMappingTest() {
        Account account = accountRepository.findById(TEST_USER_ID).orElseThrow();
        log.info(account.toString());

        Person person = personRepository.findById(TEST_PERSON_ID).orElseThrow();
        log.info(person.toString());

        Assertions.assertThat(account.getPerson()).isNotNull().isEqualTo(person);
        Assertions.assertThat(person.getAccount()).isNotNull().isEqualTo(account);
    }

    @Test
    @DisplayName("ManyToOne 단방향 매핑 테스트")
    public void manyToOneMappingTest() {
        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());

        Account author = post.getAuthor();
        log.info(author.toString());

        assertThat(author).isNotNull();
    }

    @Test
    @DisplayName("OneToMany 양방향 매핑 테스트")
    public void oneToManyMappingTest() {
        Account modifier = accountRepository.findById(TEST_MODIFIER_ID).orElseThrow();
        log.info(modifier.toString());

        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());

        assertThat(modifier.getPosts().get(0)).isNotNull().isEqualTo(post);
        assertThat(post.getModifier()).isNotNull().isEqualTo(modifier);
    }

    @Test
    @DisplayName("ManyToMany 양방향 매핑 테스트")
    public void manyToManyMappingTest() {
        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());
        log.info(post.getTags().toString());

        Tag tag = tagRepository.findById(TEST_TAG_ID).orElseThrow();
        log.info(tag.toString());
        log.info(tag.getPosts().toString());

        assertThat(post.getTags()).isNotNull();
        assertThat(tag.getPosts()).isNotNull();
    }

    @Test
    @DisplayName("Transient Field 테스트")
    public void transientFieldTest() {
        Person person = personRepository.findById(TEST_PERSON_ID).orElseThrow();
        log.info(person.toString());
        assertThat(person).isNotNull();
        assertThat(person.getEmail()).isNull();
    }

    @Test
    @DisplayName("Transient Method 테스트")
    public void transientMethodTest() {
        Item item = itemRepository.findById(TEST_ITEM_ID).orElseThrow();
        log.info(item.toString());
        assertThat(item).isNotNull();
        assertThat(item.getItemNumber()).isNull();
    }

    @Test
    @DisplayName("Field 액세스 타입 테스트")
    public void accessTypeFieldTest() {
        Person person = personRepository.findById(TEST_PERSON_ID).orElseThrow();
        log.info(person.toString());
        assertThat(person.getPhone()).isNotNull();
    }

    @Test
    @DisplayName("Property 액세스 타입 테스트")
    public void accessTypeMethodTest() {
        Item item = itemRepository.findById(TEST_ITEM_ID).orElseThrow();
        log.info(item.toString());
        assertThat(item.getItemPrice()).isNotNull();
    }

    @Test
    @DisplayName("JPA Auditing 테스트")
    public void auditingTest() {
        Item item = Item.builder()
                .id(12345L)
                .itemName("testItemName")
                .itemNumber("testItemNumber")
                .itemPrice(12345L)
                .enabled(true)
                .build();
        Item resultItem = itemRepository.save(item);
        log.info(resultItem.toString());
        log.info(resultItem.getCreatedAt().toString());
        log.info(resultItem.getModifiedAt().toString());
        assertThat(resultItem).isNotNull();
        assertThat(resultItem.getCreatedAt()).isNotNull();
        assertThat(resultItem.getModifiedAt()).isNotNull();
    }

    @Test
    @DisplayName("Pageable 적용 테스트")
    public void pageableTest() {
        int givenPage = 1;
        int givenSize = 1;
        Page<Item> page = itemRepository.findAll(PageRequest.of(givenPage, givenSize));
        log.info(page.getContent().toString());
        log.info(String.valueOf(page.getTotalPages()));
        assertThat(page).isNotNull();
        assertThat(page.toList()).isNotNull();
    }

    @Test
    @DisplayName("Eager 로딩 테스트")
    public void eagerLoadingTest() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Person person = personRepository.findById(TEST_PERSON_ID).orElseThrow();
        log.info("연관관계 접근 전 생성 여부: {}, {}", persistenceUtil.isLoaded(person.getAccount()), person.getAccount().getClass());

        Account account = person.getAccount();
        String username = account.getUsername();

        log.info("연관관계 접근 후 생성 여부: {}, {}", persistenceUtil.isLoaded(person.getAccount()), person.getAccount().getClass());

        assertThat(person).isNotNull();
        assertThat(account).isNotNull();
    }

    @Test
    @DisplayName("Lazy 로딩 테스트")
    public void lazyLoadingTest() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();

        log.info("연관관계 접근 전 생성 여부: {}, {}", persistenceUtil.isLoaded(post.getAuthor()), post.getAuthor().getClass());

        Account account = post.getAuthor();
        String username = account.getUsername();

        log.info("연관관계 접근 후 생성 여부: {}, {}", persistenceUtil.isLoaded(post.getAuthor()), post.getAuthor().getClass());

        assertThat(post).isNotNull();
        assertThat(account).isNotNull();
    }

}
