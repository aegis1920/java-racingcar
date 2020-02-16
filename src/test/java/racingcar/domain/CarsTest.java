package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.car.Car;
import racingcar.domian.Cars;
import racingcar.domian.car.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("가장 멀리 이동한 자동차의 위치 찾기")
    @Test
    void 가장_먼_자동차의_거리() {
        String inputNames = "user1,user2,user3,user4";
        Cars cars = new Cars(inputNames);
        cars.getCars().add(new Car(new Position(3), "user5"));
        assertThat(cars.findMaxPosition()).isEqualTo(3);
    }

    @DisplayName("예외 케이스: 게임에 참여하는 자동차(유저 이름)가 5대를 초과하는 경우")
    @Test
    void 자동자가_5대_초과로_오는_경우() {
        String names = "user1,user2,user3,user4,user5,user6";
        assertThatThrownBy(() -> {
            new Cars(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");
    }
}
