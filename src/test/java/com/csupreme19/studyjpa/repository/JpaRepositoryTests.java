package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.Account;
import com.csupreme19.studyjpa.domain.Person;
import com.csupreme19.studyjpa.domain.Post;
import com.csupreme19.studyjpa.domain.Tag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaRepositoryTests {
    private static final Logger log = LoggerFactory.getLogger(JpaRepositoryTests.class);

    private static final String TEST_USER_ID = "csupreme19";
    private static final Long TEST_PERSON_ID = 1L;
    private static final Long TEST_POST_ID = 1L;
    private static final String TEST_MODIFIER_ID = "honggilsoon19";
    private static final Long TEST_TAG_ID = 1L;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Test
    @DisplayName("OneToOne 양방향 매핑 테스트")
    public void oneToOneMapping() {
        Account account = accountRepository.findById(TEST_USER_ID).orElseThrow();
        log.info(account.toString());

        Person person = personRepository.findById(TEST_PERSON_ID).orElseThrow();
        log.info(person.toString());

        Assertions.assertThat(account.getPerson()).isNotNull().isEqualTo(person);
        Assertions.assertThat(person.getAccount()).isNotNull().isEqualTo(account);
    }

    @Test
    @DisplayName("ManyToOne 단방향 매핑 테스트")
    public void manyToOneMapping() {
        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());

        Account author = post.getAuthor();
        log.info(author.toString());

        Assertions.assertThat(author).isNotNull();
    }

    @Test
    @DisplayName("OneToMany 양방향 매핑 테스트")
    public void oneToManyMapping() {
        Account modifier = accountRepository.findById(TEST_MODIFIER_ID).orElseThrow();
        log.info(modifier.toString());

        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());

        Assertions.assertThat(modifier.getPosts().get(0)).isNotNull().isEqualTo(post);
        Assertions.assertThat(post.getModifier()).isNotNull().isEqualTo(modifier);
    }

    @Test
    @DisplayName("ManyToMany 양방향 매핑 테스트")
    public void manyToManyMapping() {
        Post post = postRepository.findById(TEST_POST_ID).orElseThrow();
        log.info(post.toString());
        log.info(post.getTags().toString());

        Tag tag = tagRepository.findById(TEST_TAG_ID).orElseThrow();
        log.info(tag.toString());
        log.info(tag.getPosts().toString());

        Assertions.assertThat(post.getTags()).isNotNull();
        Assertions.assertThat(tag.getPosts()).isNotNull();
    }
}
