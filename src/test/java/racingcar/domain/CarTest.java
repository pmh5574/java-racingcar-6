package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.util.StatusEnum;

class CarTest {

    @DisplayName("자동차 5글자 이하면 통과")
    @Test
    void test() {
        // given
        Car car = new Car("pobis");

        // then
        assertThat(car.getCarName()).isEqualTo("pobis");
    }

    @DisplayName("자동차 5글자 초과면 IllegalArgumentException")
    @Test
    void test2() {
        // then
        assertThatThrownBy(() -> new Car("포비포비포비"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하로 입력해 주세요.");
    }

    @DisplayName("자동차에 MOVE 들어오면 position + 1")
    @Test
    void test3() {
        // given
        Car car = new Car("pobis");

        // when
        int beforeLocation = car.getLocation();
        car.moveOrStop(StatusEnum.MOVE);

        // then
        int afterLocation = car.getLocation();
        assertThat(afterLocation).isEqualTo(beforeLocation + 1);
    }
}