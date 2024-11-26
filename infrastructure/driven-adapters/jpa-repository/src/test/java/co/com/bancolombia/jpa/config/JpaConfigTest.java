package co.com.bancolombia.jpa.config;

import co.com.bancolombia.secretsmanager.api.GenericManager;
import co.com.bancolombia.secretsmanager.api.exceptions.SecretException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class JpaConfigTest {

    @Mock
    private GenericManager manager;

    @Mock
    DataSource dataSource;

    private DBSecret dbSecretUnderTest;
    private JpaConfig jpaConfigUnderTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        jpaConfigUnderTest = new JpaConfig();

        dbSecretUnderTest = new DBSecret();
        dbSecretUnderTest.setPassword("sa");
        dbSecretUnderTest.setUsername("sa");
        dbSecretUnderTest.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

    }

    @Test
    void datasourceTest() {
        final DataSource result = jpaConfigUnderTest.datasource(dbSecretUnderTest, "org.h2.Driver");

        assertNotNull(result);
    }

    @Test
    void entityManagerFactoryTest() {

        final LocalContainerEntityManagerFactoryBean result =
                jpaConfigUnderTest.entityManagerFactory(dataSource, "dialect");

        assertNotNull(result);
    }
}
